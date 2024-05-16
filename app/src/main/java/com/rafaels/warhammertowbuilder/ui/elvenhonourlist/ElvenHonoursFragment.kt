package com.rafaels.warhammertowbuilder.ui.elvenhonourlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.rafaels.warhammertowbuilder.ui.theme.WarhammerTOWBuilderTheme
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

class ElvenHonoursFragment : Fragment() {

    companion object {
        fun newInstance() = ElvenHonoursFragment()
    }

    @OptIn(KoinExperimentalAPI::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                WarhammerTOWBuilderTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        KoinAndroidContext() {
                            //ElvenHonoursList()
                        }

                    }
                }
            }
        }
    }

}