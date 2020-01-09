package com.citizenwarwick.features.cardeditor.editorfunctions

import androidx.ui.core.Alignment
import com.citizenwarwick.features.cardeditor.config.EditorConfiguration.ELEMENT_PROPERTY_TEXT_ALIGNMENT
import com.citizenwarwick.features.cardeditor.config.EditorConfiguration.ELEMENT_PROPERTY_TEXT_CONTENT
import com.citizenwarwick.features.cardeditor.config.EditorConfiguration.ELEMENT_TYPE_TEXT
import com.citizenwarwick.features.cardeditor.model.CardEditorState
import com.citizenwarwick.features.cardeditor.model.MemoryCardElement

class AddTextEditorFunction : EditorFunction {
    override fun apply(
        editorState: CardEditorState,
        frontElements: MutableList<MemoryCardElement>,
        backElements: MutableList<MemoryCardElement>
    ) {
        // TODO would be nice to strongly type this though still reap the benefit
        //  of using ModelMap
        frontElements.add(MemoryCardElement(ELEMENT_TYPE_TEXT).apply {
            properties[ELEMENT_PROPERTY_TEXT_ALIGNMENT] = Alignment.Center.name
        })
    }
}
