package com.abhat.thebestmovielines

import com.abhat.thebestmovielines.movielinesscreen.data.response.ResponseBody
import com.abhat.thebestmovielines.movielinesscreen.data.response.data
import com.abhat.thebestmovielines.movielinesscreen.data.source.MovieLinesSource
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesRepository
import com.abhat.thebestmovielines.movielinesscreen.domain.MovieLinesUseCase
import com.abhat.thebestmovielines.movielinesscreen.presentation.MovieLinesPresenterImpl
import com.abhat.thebestmovielines.movielinesscreen.presentation.MovieLinesView
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import net.bytebuddy.implementation.bytecode.Throw
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.*


/**
 * Created by Anirudh Uppunda on 14/1/18.
 */
class MovieLinesPresenterTest {

    private lateinit var mockMovieLinesView: MovieLinesView
    private lateinit var mockMovieLinesSource: MovieLinesRepository
    private lateinit var mockMovieLinesUseCase: MovieLinesUseCase
    private lateinit var movieLinesPresenter: MovieLinesPresenterImpl

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler -> Schedulers.trampoline() }
        mockMovieLinesView = mock(MovieLinesView::class.java)
        mockMovieLinesSource = mock(MovieLinesSource::class.java)
        mockMovieLinesUseCase = mock(MovieLinesUseCase::class.java)
        movieLinesPresenter = MovieLinesPresenterImpl(mockMovieLinesUseCase)
        movieLinesPresenter.setView(mockMovieLinesView)
    }

    @Test
    fun `should hide loading`() {
        `when`(mockMovieLinesUseCase.execute()).thenReturn(Single.fromCallable({
            ResponseBody(listOf())
        }))
        movieLinesPresenter.getMovieLines("", "")
        verify(mockMovieLinesUseCase).execute()
        verify(mockMovieLinesView).hideLoading()
    }

    @Test
    fun `should show loading`() {
        `when`(mockMovieLinesUseCase.execute()).thenReturn(Single.fromCallable({
            ResponseBody(listOf())
        }))
        movieLinesPresenter.getMovieLines("", "")
        verify(mockMovieLinesUseCase).execute()
        verify(mockMovieLinesView).showLoading()
    }


    @Test
    fun `should hide loading on error` () {
        `when`(mockMovieLinesUseCase.execute()).thenReturn(Single.error<ResponseBody>(Throwable()))
        movieLinesPresenter.getMovieLines("", "")
        //verify(mockMovieLinesView).onError(Throwable())
        verify(mockMovieLinesView).hideLoading()
    }

    @Test
    fun `should load view onSuccess on success` () {
        `when`(mockMovieLinesUseCase.execute()).thenReturn(Single.fromCallable({
            ResponseBody(listOf())
        }))
        movieLinesPresenter.getMovieLines("", "")
        verify(mockMovieLinesView).onSuccess(ResponseBody(listOf()))
        verify(mockMovieLinesView).hideLoading()
    }

}