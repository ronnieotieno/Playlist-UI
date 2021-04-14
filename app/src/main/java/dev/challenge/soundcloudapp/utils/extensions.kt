package dev.challenge.soundcloudapp.utils

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


/**
 * Extends the recylerview class, adds the decoration
 */
fun RecyclerView.addDivider() {
    val dividerItemDecoration = DividerItemDecoration(
        context,
        RecyclerView.VERTICAL
    )
    addItemDecoration(dividerItemDecoration)
}