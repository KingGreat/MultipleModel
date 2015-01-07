package github.chenupt.sample;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.res.StringArrayRes;

import java.util.ArrayList;
import java.util.List;

import github.chenupt.multiplemodel.ItemEntity;
import github.chenupt.multiplemodel.ItemEntityCreator;
import github.chenupt.multiplemodel.ModelManager;
import github.chenupt.multiplemodel.ModelManagerBuilder;
import github.chenupt.multiplemodel.aa.AAModelManager;
import github.chenupt.sample.views.CustomLargeView_;
import github.chenupt.sample.views.CustomView;

/**
 * Created by chenupt@gmail.com on 1/7/15.
 * Description :
 */
@EBean
public class CommonService {

    @StringArrayRes(R.array.test_strings)
    String[] testStrings;

    public ModelManager getModelManager(){
        return ModelManagerBuilder
                .begin()
                .addModel(CustomView.class)
                .addModel(CustomLargeView_.class)
                .build(ModelManager.class);
    }

    public AAModelManager getAAModelManager(){
        return ModelManagerBuilder
                .begin()
                .addModel(CustomView.class)
                .addModel(CustomLargeView_.class)
                .build(AAModelManager.class);
    }

    public List<ItemEntity> getTestList(){
        List<ItemEntity> resultList = new ArrayList<ItemEntity>();
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityCreator.create("hello " + testStrings[i]).setModelView(CustomView.class).attach(resultList);
        }
        for (int i = 0; i < testStrings.length; i++) {
            ItemEntityCreator.create("hello " + testStrings[i]).setModelView(CustomLargeView_.class).attach(resultList);
        }
        return resultList;
    }
}
