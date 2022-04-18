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
package emerald000.cluehelper.clues.teleport;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import emerald000.cluehelper.ClueHelperPlugin;
import emerald000.cluehelper.clues.requirement.Fulfilled;
import static emerald000.cluehelper.clues.requirement.Fulfilled.FALSE;
import static emerald000.cluehelper.clues.requirement.Fulfilled.PARTIAL;
import static emerald000.cluehelper.clues.requirement.Fulfilled.TRUE;

@Getter
public class CombinedTeleport implements Teleport
{
	private String text;
	private List<Teleport> teleports;

	public CombinedTeleport(String text, Teleport... teleports)
	{
		this.text = text;
		this.teleports = Arrays.asList(teleports);
	}

	public String getText()
	{
		return text;
	}

	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		Fulfilled returnValue = TRUE;

		for (Teleport teleport : teleports)
		{
			switch (teleport.fulfilledBy(plugin))
			{
				case FALSE:
					return FALSE;

				case PARTIAL:
					returnValue = PARTIAL;
			}
		}

		return returnValue;
	}


}
