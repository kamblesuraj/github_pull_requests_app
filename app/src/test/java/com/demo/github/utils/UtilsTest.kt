package com.demo.github.utils

import com.demo.github.data.model.PullRequestModel
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Response


class UtilsTest {
    
    @Test
    fun `Heading title is right`(){
        val heading = getHeadingTitle("closed")
        assertEquals(heading, "Closed pull requests")
    }
    
    @Test
    fun `Heading title is wrong`(){
        val heading = getHeadingTitle("open")
        assertEquals(heading, "Pull requests")
    }
    
    @Test
    fun `Info text is right`(){
        val pullRequest = PullRequestModel(
            number = 2345,
            state = "closed",
            closed_at = "2022-07-20T01:24:39Z",
        )
        val infoText = getInfoText(pullRequest)
        assertEquals(infoText, "#2345 closed on 20 July 2022")
    }
    
    @Test
    fun `Info text with wrong date format`(){
        val pullRequest = PullRequestModel(
            number = 2345,
            state = "closed",
            closed_at = "2022-07-20T01:24:39",
        )
        val infoText = getInfoText(pullRequest)
        assertEquals(infoText, "#2345 closed")
    }
    
    @Test
    fun `Info text with wrong state`(){
        val pullRequest = PullRequestModel(
            number = 2345,
            state = "open",
            closed_at = "2022-07-20T01:24:39",
        )
        val infoText = getInfoText(pullRequest)
        assertEquals(infoText, "#2345")
    }
    
    @Test
    fun `Info text with null date`(){
        val pullRequest = PullRequestModel(
            number = 2345,
            state = "closed",
            closed_at = null,
        )
        val infoText = getInfoText(pullRequest)
        assertEquals(infoText, "#2345 closed")
    }
    
    @Test
    fun `Response result with right response`(){
        val dummyData = listOf(
            PullRequestModel(),
            PullRequestModel()
        )
        val response = handleResponseResult(Response.success(dummyData))
        
        assertEquals(response.data, dummyData)
        assertEquals(response.message, null)
    }
}