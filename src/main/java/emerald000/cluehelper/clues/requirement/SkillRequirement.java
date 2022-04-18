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

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import emerald000.cluehelper.ClueHelperPlugin;

@Getter
@AllArgsConstructor
public class SkillRequirement implements Requirement
{
	final Skill skill;
	final int level;
	final boolean boostAllowed;

	public SkillRequirement(Skill skill, int level)
	{
		this(skill, level, true);
	}

	@Override
	public String getText(Client client)
	{
		return level + " " + skill.getName();
	}

	@Override
	public Fulfilled fulfilledBy(ClueHelperPlugin plugin)
	{
		Client client = plugin.getClient();

		if (client.getBoostedSkillLevel(skill) >= level)
		{
			return Fulfilled.TRUE;
		}
		else if (boostAllowed)
		{
			int baseLevel = client.getRealSkillLevel(skill);
			if (baseLevel + this.getMaxBoost(skill, baseLevel) >= level)
			{
				return Fulfilled.PARTIAL;
			}
		}
		return Fulfilled.FALSE;
	}

	private int getMaxBoost(Skill skill, int baseLevel)
	{
		switch (skill)
		{
			case AGILITY:
			case CONSTRUCTION:
			case CRAFTING:
			case FARMING:
			case FIREMAKING:
			case FISHING:
			case FLETCHING:
			case HERBLORE:
			case HUNTER:
			case MINING:
			case PRAYER:
			case RUNECRAFT:
			case SLAYER:
			case SMITHING:
			case THIEVING:
			case WOODCUTTING:
			{
				// Spicy stew
				return 5;
			}
			case ATTACK:
			case DEFENCE:
			{
				if (baseLevel <= 64)
				{
					// Super combat potion
					return 3 * baseLevel / 20 + 5;
				}
				else
				{
					// Zamorak/Saradomin Brew
					return baseLevel / 5 + 2;
				}
			}
			case COOKING:
			{
				if (baseLevel <= 79)
				{
					// Spicy stew
					return 5;
				}
				else
				{
					// Chef's delight(m)
					return 6;
				}
			}
			case HITPOINTS:
			{
				if (baseLevel <= 49)
				{
					// Amulet of the Damned
					return 10;
				}
				else if (baseLevel <= 74)
				{
					// Anglerfish
					return baseLevel / 10 + 6;
				}
				else if (baseLevel <= 92)
				{
					// Anglerfish
					return baseLevel / 10 + 8;
				}
				else
				{
					// Anglerfish
					return baseLevel / 10 + 13;
				}
			}
			case MAGIC:
			{
				if (baseLevel <= 49)
				{
					// Spicy Stew
					return 5;
				}
				else
				{
					// Imbued Heart
					return baseLevel / 10 + 1;
				}
			}
			case RANGED:
			{
				if (baseLevel <= 19)
				{
					// Spicy Stew
					return 5;
				}
				else
				{
					return baseLevel / 10 + 4;
				}
			}
			case STRENGTH:
			{
				if (baseLevel <= 39)
				{
					// Keg of beer
					return 10;
				}
				else
				{
					return 3 * baseLevel / 20 + 5;
				}
			}
			case OVERALL:
			{
				return 0;
			}
			default:
			{
				throw new IllegalStateException("Unknown skill: " + skill);
			}
		}
	}
}
