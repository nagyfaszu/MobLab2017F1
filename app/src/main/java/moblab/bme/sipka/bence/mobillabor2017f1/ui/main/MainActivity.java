package moblab.bme.sipka.bence.mobillabor2017f1.ui.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import moblab.bme.sipka.bence.mobillabor2017f1.MobSoftApplication;
import moblab.bme.sipka.bence.mobillabor2017f1.R;
import moblab.bme.sipka.bence.mobillabor2017f1.model.Recipe;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeGroup;
import moblab.bme.sipka.bence.mobillabor2017f1.model.RecipeHeader;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.about.AboutActivity;
import moblab.bme.sipka.bence.mobillabor2017f1.ui.recipe.RecipeActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    @Inject
    MainPresenter presenter;

    ListView list;
    RecipeGroupAdapter adapter = new RecipeGroupAdapter();

    private class RecipeGroupAdapter extends BaseAdapter{

        private List<RecipeGroup> groups = Collections.emptyList();

        public void setGroups(List<RecipeGroup> groups) {
            this.groups = groups;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return groups.size();
        }

        @Override
        public RecipeGroup getItem(int position) {
            return groups.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item_recipe_group, null);
            }
            RecipeGroup g = getItem(position);
            LinearLayout itemslayout = (LinearLayout) convertView.findViewById(R.id.recipe_groups_items_linear);
            TextView groupname = (TextView) convertView.findViewById(R.id.list_item_group_name);
            groupname.setText(g.getTitle());
            for(int i = 0; i < g.getRecipes().size(); ++i){
                final RecipeHeader r = g.getRecipes().get(i);
                View subitem ;
                if(i < itemslayout.getChildCount()){
                    subitem =itemslayout.getChildAt(i);
                }else{
                    subitem = LayoutInflater.from(MainActivity.this).inflate(R.layout.subitem_list_recipe_header, null);
                    itemslayout.addView(subitem);
                }
                TextView name = (TextView) subitem.findViewById(R.id.subitem_recipe_header_name);
                ImageView image = (ImageView) subitem.findViewById(R.id.subitem_recipe_header_image);
                name.setText(r.getTitle());

                if(r.getTileImage()!=null) {
                    Glide.with(MainActivity.this).load(r.getTileImage()).into(image);
                }

                subitem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.showRecipe(r);
                    }
                });
            }

            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobSoftApplication application = (MobSoftApplication) getApplication();

        Tracker tracker = application.getDefaultTracker();
        tracker.setScreenName("MainActivity");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());

        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.main_list);
        list.setAdapter(adapter);

        MobSoftApplication.injector.inject(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachScreen(this);

        presenter.getRecipeGroups();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachScreen();
    }


    @Override
    public void showRecipeGroups(List<RecipeGroup> groups) {
        adapter.setGroups(groups);
    }

    @Override
    public void showRecipe(RecipeHeader recipe) {
        Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(RecipeActivity.EXTRA_RECIPE_ID, recipe.getId());
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void titleClick(View v){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public static Bitmap getDrawable(String url){
        try{
            InputStream is = new URL(url).openStream();
            return BitmapFactory.decodeStream(is);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
