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
package com.citizenwarwick.features.cardeditor.config

import com.citizenwarwick.features.cardeditor.R
import com.citizenwarwick.features.cardeditor.editorfunctions.AddOvalShapeEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.AddTextEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.ClearAllEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.DeleteElementEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.RotateCardEditorFunction

object EditorConfiguration {
    /**
     * Constants for the text element
     */
    const val ELEMENT_TYPE_TEXT_DEFAULT_MIN_SIZE_EM = 4.0f
    const val ELEMENT_TYPE_TEXT_DEFAULT_MAX_SIZE_EM = 32.0f

    val editorFunctionConfiguration: List<EditorFunctionConfig> = mutableListOf(
        EditorFunctionConfig("rotate-card", R.drawable.ic_editor_tool_rotate, ::RotateCardEditorFunction),
        EditorFunctionConfig("add-text", R.drawable.ic_editor_tool_add_text, ::AddTextEditorFunction),
        EditorFunctionConfig("add-oval", R.drawable.ic_editor_tool_add_oval, ::AddOvalShapeEditorFunction),
        EditorFunctionConfig("delete-element", R.drawable.ic_editor_tool_delete, ::DeleteElementEditorFunction),
        EditorFunctionConfig("clear-all", R.drawable.ic_editor_tool_clear_all, ::ClearAllEditorFunction)
    )
}
