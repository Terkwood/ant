package farm.terkwood.ant

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ktx.collections.gdxArrayOf

class AntGame : ApplicationAdapter() {
    private var batch: SpriteBatch? = null
    private var img: Texture? = null

    private val FRAME_COLS = 8
    private val FRAME_ROWS = 7
    private var walkAnimation: Animation<TextureRegion>? = null
    private var stage: Stage? = null

    override fun create() {
        batch = SpriteBatch()
        img = Texture("ant_walk.png")
        stage = Stage(ScreenViewport())
        if (stage != null) {
            Gdx.input.inputProcessor = stage
        }

        val tmp: Array<Array<TextureRegion?>?>? =
            TextureRegion.split(
                img,
                img?.let { it.width / FRAME_COLS } ?: 0,
                img?.let { it.height / FRAME_ROWS } ?: 0
            )

        val walkFrames = gdxArrayOf<TextureRegion>()
        var index = 0
        if (tmp != null) {
            for (i in 0..FRAME_ROWS) {
                for (j in 0..FRAME_COLS) {
                    if (tmp.size >= i && tmp[index] != null && tmp[index]?.size ?: 0 >= j) {
                        //walkFrames[index++] = tmp[i]!![j]
                    }
                }
            }
        }



    }

    override fun resize(width: Int, height: Int) {
        stage?.viewport?.update(width, height, true)
    }

    override fun render() {
        Gdx.gl.glClearColor(0.2f, 0.5f, 0.8f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch!!.begin()
        batch!!.draw(img, 0f, 0f)
        batch!!.end()
    }

    override fun dispose() {
        batch!!.dispose()
        img!!.dispose()
    }
}
