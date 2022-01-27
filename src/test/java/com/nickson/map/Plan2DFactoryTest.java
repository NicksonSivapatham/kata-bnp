package com.nickson.map;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Plan2DFactoryTest {

	@Test
	void testGetRectangularMap() {
		RectangularMap expectedMap = new  RectangularMap(5l,3l);
		
		assertEquals(expectedMap, Plan2DFactory.getRectangularMap("5 3"));
		assertThrows(IllegalArgumentException.class, () -> Plan2DFactory.getRectangularMap("5 D"));
	}

}
