package game.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import game.main.Objects.BoxObject;
import game.main.components.*;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;

	OrthographicCamera camera = new OrthographicCamera();

	Player player;
	BoxObject box = new BoxObject();

	ModManager modManager;



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
		for (String i: MorinioParser.getFileNames()){
			System.out.println(i);
		}
		Mods.create();

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		Map.render(batch);
		player.render();
		box.render(batch);
		Mods.render(batch);
		Collider.addCollider(player.playerRec,box.ObjectRec);

	}
	
	@Override
	public void dispose () {
		player.dispose();
	}
}
