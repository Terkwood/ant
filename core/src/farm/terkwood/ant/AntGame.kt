package farm.terkwood.ant

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class AntGame : ApplicationAdapter() {
    private var batch: SpriteBatch? = null
    private var img: Texture? = null
    override fun create() {
        batch = SpriteBatch()
        img = Texture("ant_walk.png")
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
