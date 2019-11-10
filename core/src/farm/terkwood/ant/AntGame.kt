package farm.terkwood.ant

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion

class AntGame : ApplicationAdapter() {
    private var batch: SpriteBatch? = null
    private var img: Texture? = null

    private val FRAME_COLS = 8
    private val FRAME_ROWS = 8
    private val UNUSED_FRAMES = 2
    private var walkAnimation: Animation<TextureRegion>? = null

    override fun create() {
        batch = SpriteBatch()
        img = Texture("ant_walk.png")

        val tmp: Array<Array<TextureRegion?>?>? =
            TextureRegion.split(
                img,
                img?.let { it.width / FRAME_COLS } ?: 0,
                img?.let { it.height / FRAME_ROWS } ?: 0
            )

        // TODO
        //val walkFrames: Array<TextureRegion?> = Array(FRAME_COLS * FRAME_ROWS) { i -> tmp[i / FRAME_COLS][i / FRAME_ROWS] }
        //walkAnimation = Animation<TextureRegion>(0.025f, TODO())
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
