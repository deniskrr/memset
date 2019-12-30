package com.citizenwarwick.features.cardeditor.model.vm

import androidx.compose.frames.ModelList
import androidx.compose.frames.modelListOf
import androidx.lifecycle.ViewModel
import com.citizenwarwick.features.cardeditor.CardEditorModel
import com.citizenwarwick.features.cardeditor.LoadingState
import com.citizenwarwick.features.cardeditor.config.EditorConfiguration
import com.citizenwarwick.features.cardeditor.config.EditorFunctionConfig
import com.citizenwarwick.features.cardeditor.editorfunctions.AddBackgroundImageEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.AddTextEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.ClearAllEditorFunction
import com.citizenwarwick.features.cardeditor.editorfunctions.EditorFunction
import com.citizenwarwick.features.cardeditor.model.CardEditorState
import com.citizenwarwick.features.cardeditor.model.MemoryCard
import com.citizenwarwick.features.cardeditor.model.MemoryCardElement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CardEditorViewModel : ViewModel(), CardEditorModel {
    private val cardFrontElements: ModelList<MemoryCardElement> = modelListOf()
    private val cardBackElements: ModelList<MemoryCardElement> = modelListOf()
    /**
     * CardEditorState gets bound to composed UI down the line and we want
     * to keep it (and its members) immutable to the compose ui tree though
     * still able to edit it here (only one source of truth, only one thing allowed
     * to modify this data and that is this view model)
     */
    override val state: CardEditorState =
        CardEditorState(
            loadingState = LoadingState.Loaded,
            card = MemoryCard(cardFrontElements, cardBackElements)
        )

    private val editorFunctions: Map<String, EditorFunction> = mapOf(
        Pair(EditorConfiguration.FUNC_ADD_TEXT, AddTextEditorFunction()),
        Pair(EditorConfiguration.FUNC_ADD_BG_IMAGE, AddBackgroundImageEditorFunction()),
        Pair(EditorConfiguration.FUNC_CLEAR_ALL, ClearAllEditorFunction())
    )

    override fun applyEditorFunction(editorFunction: EditorFunctionConfig) {
        editorFunctions[editorFunction.name]?.apply(state, cardFrontElements, cardBackElements)
    }

    override fun selectElement(element: MemoryCardElement) {
        state.selectedElement = element
    }

    init {
        state.loadingState = LoadingState.Loading

        GlobalScope.launch(Dispatchers.IO) {
            delay(2000)
            GlobalScope.launch(Dispatchers.Main) {
                state.loadingState = LoadingState.Loaded
            }
        }

    }
}
