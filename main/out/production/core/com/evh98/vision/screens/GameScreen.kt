package com.evh98.vision.screens

import com.badlogic.gdx.graphics.OrthographicCamera
import com.evh98.vision.Vision
import com.evh98.vision.models.Models
import com.evh98.vision.ui.GamePane
import com.evh98.vision.util.Controller
import com.evh98.vision.util.Palette

class GameScreen(vision: Vision): VisionScreen(vision) {

    var scrollCamera = OrthographicCamera()

    var x = -1
    var y = -1

    val gamePanes = mutableListOf<GamePane>()

    override fun show() {
        super.show()

        start(Palette.RED)

        generatePanes()
    }

    override fun draw(delta: Float) {
        renderPanes()
    }

    override fun update() {
        super.update()
        
        if (Controller.isNavigationKey()) {
            val newCoords = Controller.getNewXY(x, y, 3, gamePanes.size / 3, gamePanes.size)
            x = newCoords[0]
            y = newCoords[1]

            print(gamePanes.size / 3)
        }
        else if (Controller.isRed()) {
            vision.screen = vision.home_screen
        }
    }

    private fun generatePanes() {
        for (i in 0 .. Models.games.size - 1) {
            val gamePane = GamePane(Models.games[i], i % 3, i / 3)
            gamePanes.add(gamePane)
        }
    }

    private fun renderPanes() {
        for (gamePane in gamePanes) {
            if (gamePane.xPos == x && gamePane.yPos == y) {
                gamePane.renderSelect(sprite_batch, shape_renderer)
            } else {
                gamePane.renderUnselect(sprite_batch)
            }
        }
    }
}