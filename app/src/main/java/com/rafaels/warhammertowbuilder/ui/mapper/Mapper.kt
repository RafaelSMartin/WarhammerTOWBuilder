package com.rafaels.warhammertowbuilder.ui.mapper

import com.rafaels.warhammertowbuilder.R

fun mapImageDrawable(name: String): Int =
    when (name) {
        "High Elf Prince" -> R.drawable.prince
        else -> R.drawable.dragons
    }
