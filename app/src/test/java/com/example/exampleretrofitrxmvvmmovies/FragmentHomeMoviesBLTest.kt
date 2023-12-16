package com.example.exampleretrofitrxmvvmmovies

import android.content.Context
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Implementations.FragmentHomeMoviesBL
import com.example.exampleretrofitrxmvvmmovies.Fragments.Movies.Interfaces.IFragmentHomeMoviesListener
import com.example.exampleretrofitrxmvvmmovies.Database.IMovieResponder
import com.example.exampleretrofitrxmvvmmovies.Database.IResponder
import com.example.exampleretrofitrxmvvmmovies.Models.Movie
import com.example.exampleretrofitrxmvvmmovies.Models.MoviesResponse
import com.example.exampleretrofitrxmvvmmovies.utils.isNetworkAvailable
import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.just
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class FragmentHomeMoviesBLTest {

    @RelaxedMockK
    private lateinit var listener: IFragmentHomeMoviesListener

    @RelaxedMockK
    private lateinit var context: Context

    @RelaxedMockK
    private lateinit var mockMovieRepository: IMovieResponder
    @RelaxedMockK
    private lateinit var mockIRepository: IResponder

    private lateinit var bl: FragmentHomeMoviesBL

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        bl = FragmentHomeMoviesBL(listener)
    }

    @Test
    fun testCallServiceWithNetworkAvailable()= runBlocking {
        //Give
        val movies = MoviesResponse()
        movies.results = emptyList<Movie>().toMutableList()
        // Configurar el comportamiento esperado del objeto burla
        coEvery { mockMovieRepository.getMovies() } returns Unit
        coEvery { listener.responseHomeMovies(movies) } just Runs
        // Configurar el estado de la red como disponible
        coEvery { isNetworkAvailable(context) } returns true

        //When
        // Llamar a la función que quieres probar en la clase
        bl.callService()

        //Then
        // Verificar que los métodos del objeto burla fueron llamados con los argumentos esperados
        coVerify{ mockMovieRepository.getMovies() }
    }
    @Test
    fun testCallServiceWithNetworkNotAvailable() = runBlocking {
        // Configurar el estado de la red como no disponible
        coEvery { isNetworkAvailable(context) } returns false

        // Llamar a la función que quieres probar en la clase
        bl.callService()

        // Verificar que el método del objeto burla no fue llamado
        coVerify(exactly = 0) { mockMovieRepository.getMovies() }
    }

}