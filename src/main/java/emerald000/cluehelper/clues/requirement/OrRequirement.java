/*
 * Copyright (c) 2020, emerald000
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package emerald000.cluehelper.clues.requirement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import net.runelite.api.Client;
import emerald000.cluehelper.ClueHelperPlugin;

@Getter
public class OrRequirement implements Requirement
{
	final String text;
	final List<Requirement> requirements;

	public OrRequirement(Requirement... requirements)
	{
		this("N/A", requirements);
	}

	public OrRequirement(List<Requirement> requirements, Requirement... otherRequirements)
	{
		this("N/A", requirements, otherRequirements);
	}

	public OrRequirement(String text, List<Requirement> requirements, Requirement... otherRequirements)
	{
		this.text = text;

		List<Requirement> totalRequirements = new ArrayList<>(requirements);
		Collections.addAll(totalRequirements, otherRequirements);
		this.requirements = totalRequirements;
	}

	public OrRequirement(String text, Requirement... requirements)
	{
		this.text = text;
		this.requirements = Arrays.asList(requirements);
	}

	@Override
	public String getText(Client client)
	{
		return text;
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		Fulfilled returnValue = Fulfilled.FALSE;
		for (Requirement requirement : requirements)
		{
			switch (requirement.fulfilledBy(plugin))
			{
				case TRUE:
					return Fulfilled.TRUE;
				case PARTIAL:
					returnValue = Fulfilled.PARTIAL;
			}
		}
		return returnValue;
	}
}
