package github.chenupt.sample.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import github.chenupt.multiplemodel.BaseItemModel;
import github.chenupt.sample.R;

/**
 * Created by chenupt@gmail.com on 11/26/14.
 * Description :
 */
public class CustomView extends BaseItemModel {

    private TextView textView;

    public CustomView(Context context) {
        super(context);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.view_item_custom, this, true);
        textView = (TextView) findViewById(R.id.text_view);
    }

    @Override
    public void bindView() {
        textView.setText(viewPosition + ". " + model.getContent());
    }
}
