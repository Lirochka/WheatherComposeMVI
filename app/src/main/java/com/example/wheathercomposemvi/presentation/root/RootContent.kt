package com.example.wheathercomposemvi.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.example.wheathercomposemvi.presentation.details.DetailsContent
import com.example.wheathercomposemvi.presentation.favourite.FavouriteContent
import com.example.wheathercomposemvi.presentation.search.SearchContent
import com.example.wheathercomposemvi.presentation.ui.theme.WheatherComposeMVI

@Composable
fun RootContent(component: RootComponent) {

    WheatherComposeMVI {
        Children(
            stack = component.stack
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }

                is RootComponent.Child.Favourite -> {
                    FavouriteContent(component = instance.component)
                }

                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}