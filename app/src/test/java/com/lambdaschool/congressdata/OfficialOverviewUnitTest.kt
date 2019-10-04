package com.lambdaschool.congressdata

import org.junit.Assert.assertEquals
import org.junit.Test

class OfficialOverviewUnitTest {

    @Test
    fun displayName() {
        // Setup
        val firstName = "Robert"
        val middleName = "B."
        val lastName = "Aberholt"
        val party = "R"
        val state = "AL"
        val id = "3"

        // Execute
        val displayCongresspersonCard = OfficialOverview(firstName, middleName, lastName, party, state, id)

        // Check
        assertEquals("Robert B. Aberholt", displayCongresspersonCard.displayName)
        assertEquals("R", displayCongresspersonCard.party)
        assertEquals("AL", displayCongresspersonCard.state)
        assertEquals("3", displayCongresspersonCard.id)
    }
}