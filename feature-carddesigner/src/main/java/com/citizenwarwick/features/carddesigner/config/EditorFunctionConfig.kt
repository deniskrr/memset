/**
 * Copyright 2020 Ian Warwick
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.citizenwarwick.features.carddesigner.config

import androidx.annotation.DrawableRes
import androidx.compose.Model
import com.citizenwarwick.features.carddesigner.editorfunctions.EditorFunction
import com.citizenwarwick.features.carddesigner.CardDesignerState

@Model
data class EditorFunctionConfig(
    val name: String, @DrawableRes val icon: Int,
    val function: (state: CardDesignerState) -> EditorFunction
)
