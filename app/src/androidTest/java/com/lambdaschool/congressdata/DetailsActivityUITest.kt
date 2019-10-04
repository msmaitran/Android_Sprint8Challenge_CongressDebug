package com.lambdaschool.congressdata

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DetailsActivityUITest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(DetailsActivity::class.java)

    @Test
    fun detailsActivity() {
        // Setup
        val profileName = "Robert B. Aderholt"
        val profileParty = "Republican"
        val profileDistrict = "AL - District 4"
        val profileTwitter = "Twitter"
        val profileFacebook = "Facebook"
        val profileMap = "1203 Longworth House Office Building"


        onView(withId(R.id.profile_name)).check(matches(withText(profileName)))
        onView(withId(R.id.profile_party)).check(matches(withText(profileParty)))
        onView(withId(R.id.profile_district)).check(matches(withText(profileDistrict)))
        onView(withId(R.id.profile_twitter)).check(matches(withText(profileTwitter)))
        onView(withId(R.id.profile_facebook)).check(matches(withText(profileFacebook)))
        onView(withId(R.id.profile_map)).check(matches(withText(profileMap)))

    }
}