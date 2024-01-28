package com.majo.shikimori.compose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester

@Composable
fun TopAppBarWithSearch(
    title: @Composable () -> Unit,
    modifier: Modifier,
    actions: @Composable RowScope.() -> Unit = {},
    onSearchResult: (String?) -> Unit = {},
    placeholder: @Composable () -> Unit = {},
) {
    var expanded by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }

    val actionsRow = @Composable {
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            content = actions
        )
    }

    Row(modifier = modifier.height(IntrinsicSize.Max)) {
        Box(
            modifier =  Modifier.weight(1f).fillMaxHeight(),
            contentAlignment = Alignment.CenterStart,
        ) {
            when (expanded) {
                false -> {
                    title()
                }
                true -> {
                    SearchBar(
                        onSearch = onSearchResult,
                        placeholder = placeholder,
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        focusRequester.requestFocus()
                    }
                }
            }
        }
        SearchIcon {
            expanded = !expanded
        }
        actionsRow()
    }
}

@Composable
fun SearchIcon(onSearchClick: () -> Unit) {
    IconButton(onClick = onSearchClick) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search icon",
        )
    }
}