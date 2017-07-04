package com.evh98.vision.ui

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.evh98.vision.Vision
import com.evh98.vision.models.Game
import com.evh98.vision.util.Graphics
import com.evh98.vision.util.Palette

class GamePane(val game: Game, val xPos: Int, val yPos: Int) {

    val Vision = Vision()

    val WIDTH = 920F
    val HEIGHT = 430F
    var x = 0
    var y = 0

    init {
        x = 320 + (xPos * 1140)
        y = 278 + (yPos * 557)
    }

    fun renderUnselect(sprite_batch: SpriteBatch) {
        renderIcon(sprite_batch)
    }

    fun renderSelect(sprite_batch: SpriteBatch, shape_renderer: ShapeRenderer) {
        renderIcon(sprite_batch)
        renderIndicator(shape_renderer)
    }

    private fun renderIcon(sprite_batch: SpriteBatch) {
        sprite_batch.begin()
        Graphics.drawSprite(sprite_batch, game.icon!!, x.toFloat(), y.toFloat(), WIDTH, HEIGHT)
        sprite_batch.end()
    }

    private fun renderIndicator(shape_renderer: ShapeRenderer) {
        shape_renderer.begin(ShapeRenderer.ShapeType.Filled)
        val red = Palette.RED
        shape_renderer.color = Color(red.r, red.g, red.b, 0.5F)
        Graphics.drawRect(shape_renderer, x.toFloat(), y + HEIGHT - 64, WIDTH, 64F)
        shape_renderer.end()
    }
}