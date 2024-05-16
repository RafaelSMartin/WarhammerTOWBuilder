package com.rafaels.warhammertowbuilder.ui.unitItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rafaels.domain.model.SpecialRuleModel
import com.rafaels.domain.model.UnitModel
import com.rafaels.warhammertowbuilder.ui.MainViewModel
import com.rafaels.warhammertowbuilder.ui.mapImageDrawable
import org.koin.androidx.compose.koinViewModel


@Composable
fun ArmyList(navController: NavController, mainViewModel: MainViewModel = koinViewModel()) {
    val uiState by mainViewModel.uiUnitState.collectAsState()

    UnitItemColumn(unitModels = uiState.units)

}

@Composable
fun UnitItemColumn(
    unitModels: List<UnitModel>,
) {
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(unitModels) {
            UnitItem(it)
        }
    }
}

@Composable
fun UnitItem(unit: UnitModel) {
    Box {
        Image(
            painter = painterResource(id = mapImageDrawable(unit.unitName)),
            contentDescription = "null",
            modifier = Modifier
                .matchParentSize()
                .alpha(0.25f),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = unit.unitName)
            Text(text = "---------------------------------------")
            UnitItemProfile(unit)
            UnitItemSpecialRules(unit.specialRules)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun UnitItemProfile(unit: UnitModel) {

    Row {
        Box(Modifier.weight(0.30f)) {
            Text(text = unit.unitName)
        }

        Box(Modifier.weight(0.70f)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "M\n" + unit.attributes.movement.toString())
                Text(text = "WS\n" + unit.attributes.weaponSkill.toString())
                Text(text = "BS\n" + unit.attributes.ballisticSkill.toString())
                Text(text = "S\n" + unit.attributes.strength.toString())
                Text(text = "T\n" + unit.attributes.toughness.toString())
                Text(text = "W\n" + unit.attributes.wounds.toString())
                Text(text = "I\n" + unit.attributes.initiative.toString())
                Text(text = "A\n" + unit.attributes.attacks.toString())
                Text(text = "Ld\n" + unit.attributes.leadership.toString())
                Text(text = "Points\n" + unit.attributes.basicPoint.toString())
            }
        }

    }
}

@Composable
fun UnitItemSpecialRules(specialRules: List<SpecialRuleModel>) {
    Column(Modifier.padding(vertical = 8.dp)) {
        specialRules.forEach { specialRule ->

            // meter un decorador
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(specialRule.rule + ": ")
                }
                append(specialRule.description + "\n")
            })
        }
    }
}