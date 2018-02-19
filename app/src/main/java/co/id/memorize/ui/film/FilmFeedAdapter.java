package co.id.memorize.ui.film;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.id.memorize.R;
import co.id.memorize.model.Film;
import co.id.memorize.ui.extension.BaseViewAdapter;
import co.id.memorize.ui.extension.BaseViewHolder;

/**
 * Created by eminartiys on 17/02/18.
 */

public class FilmFeedAdapter extends BaseViewAdapter<Film> {

    @Override
    public void setItems(List<Film> items) {
        super.setItems(items);
    }

    @Override
    public BaseViewHolder<Film> createHolder(ViewGroup parent, int viewType) {
        return new FilmViewHolder(R.layout.view_film_item, parent);
    }

    @Override
    public void bindHolder(BaseViewHolder holder, final int position) {
        holder.bindView(getItem(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItemClickListener() == null) return;

                getItemClickListener().onItemClickListener(getItem(position));
            }
        });
    }

    public static class FilmViewHolder extends BaseViewHolder<Film> {

        @Bind(R.id.title) TextView titleView;

        public FilmViewHolder(@LayoutRes int resId, ViewGroup parent) {
            super(resId, parent);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bindView(final Film film) {
            titleView.setText(film.getTitle());

        }
    }
}
