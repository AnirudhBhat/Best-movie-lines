package com.abhat.thebestmovielines

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.data.response.data
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesRepository
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import rx.Single

/**
 * Created by Anirudh Uppunda on 14/1/18.
 */
class MovieLinesUseCaseTest {

    private lateinit var movieLinesUseCase: MovieLinesUseCase
    private lateinit var mockMovieRepository: MovieLinesRepository

    @Before
    fun `setup`() {
        mockMovieRepository = mock(MovieLinesRepository::class.java)
        movieLinesUseCase = MovieLinesUseCase(mockMovieRepository)
    }

    @Test
    fun `should get data from repository`() {
        `when`(mockMovieRepository.getMovieLines("", "")).thenReturn(Single.just(ResponseBody(listOf())))
        movieLinesUseCase.setQueryParams("", "")
        movieLinesUseCase.execute()
        verify(mockMovieRepository).getMovieLines("", "")
    }
}