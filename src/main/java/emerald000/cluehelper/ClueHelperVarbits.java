package emerald000.cluehelper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClueHelperVarbits
{

	/**
	 * Digsite Pendant
	 */
	DIGSITE_PENDANT_FOSSIL_ISLAND_UNLOCKED(5983),
	DIGSITE_PENDANT_LITHKREN_UNLOCKED(6142),

	/**
	 * Number of daily teleports used
	 */
	EXPLORER_RING_TELEPORTS(4552),
	DESERT_AMULET_TELEPORTS(4558),
	FREMENNIK_SEA_BOOTS_TELEPORTS(5005);

	/**
	 * The raw varbit ID.
	 */
	private final int id;
}
