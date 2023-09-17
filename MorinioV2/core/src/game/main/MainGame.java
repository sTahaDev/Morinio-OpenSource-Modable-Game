package game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import game.main.Objects.BoxObject;
import game.main.components.*;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;

	OrthographicCamera camera = new OrthographicCamera();

	Player player;
	BoxObject box = new BoxObject();

	ModManager modManager;

	UI Ui = new UI();

	World world = new World(new Vector2(0, 0), true);


	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player(batch,camera);
		player.create();
		Map.create();
		box.create();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		modManager = new ModManager();
		modManager.create();
		Mods.create();
		Ui.create();



	}

	@Override
	public void render () {
		ScreenUtils.clear(0.25f, 0.25f, 0.25f, 1);

		Map.render(batch);
		player.render();
		box.render();
		box.draw(batch);
		Mods.render(batch);

		Collider.addCollider(Player.getRec(),box.ObjectRec);

		Ui.render();

	}
	
	@Override
	public void dispose () {
		player.dispose();
	}
}
