package com.rhodar.mobile.codescrum.validtest

import com.rhodar.mobile.codescrum.validtest.data.api.LastFmApiClient
import org.junit.Before
import org.junit.Test


class ApiTest {
    lateinit var lastFmClient: LastFmApiClient

    @Before
    fun init() {
        lastFmClient = LastFmApiClient()
    }


    @Test
    fun testRemoteTopTrack() {
        val testObserver = lastFmClient.getTopTracks().test()
        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertValue { it.topTrack.track.isNotEmpty() }
    }

    @Test
    fun testRemoteTopArtist(){
        val testObserver = lastFmClient.getTopArtist().test()
        testObserver.awaitTerminalEvent()
        testObserver
                .assertNoErrors()
                .assertValue { it.topArtist.artists.isNotEmpty() }
    }
}