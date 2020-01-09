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
package com.citizenwarwick.features.cardeditor.editorfunctions

import com.citizenwarwick.features.cardeditor.model.CardEditorState
import com.citizenwarwick.features.cardeditor.model.MemoryCardElement

class DeleteElementEditorFunction : EditorFunction {
    override fun apply(
        editorState: CardEditorState,
        frontElements: MutableList<MemoryCardElement>,
        backElements: MutableList<MemoryCardElement>
    ) {
        editorState.selectedElement?.let { element ->
            if (frontElements.remove(element)) {
                editorState.selectedElement = null
            }
            if (backElements.remove(element)) {
                editorState.selectedElement = null
            }
        }
    }
}
