package co.id.memorize.ui.film;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.id.memorize.Injector;
import co.id.memorize.R;
import co.id.memorize.model.Film;
import co.id.memorize.repository.film.FilmRepository;
import co.id.memorize.ui.extension.BaseViewAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFeedFragment extends Fragment implements FilmFeedContract.View {

    @Bind(R.id.list_view) RecyclerView recyclerView;
    @Bind(R.id.empty_view) ConstraintLayout emptyLayout;

    @Inject FilmRepository repository;

    private FilmFeedContract.Presenter presenter;
    private FilmFeedAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Injector.obtain(getActivity()).inject(this);

        new FilmFeedPresenter(this, repository);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new FilmFeedAdapter();

        adapter.setItemClickListener(new BaseViewAdapter.ItemClickListener() {
            @Override
            public void onItemClickListener(Object item) {
                if (item instanceof Film) {
                    Toast.makeText(getContext(), "This is film " + ((Film) item).getTitle(), Toast.LENGTH_LONG);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film_feed, container, false);
    }

    @Override
    public void setPresenter(FilmFeedContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setItemToView(List<Film> list) {
        emptyLayout.setVisibility(View.GONE);
        adapter.clearData();
        adapter.setItems(list);
    }

    @Override
    public void setNoDataLoadToView() {
        recyclerView.setVisibility(View.GONE);
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void setErrorToView() {
        recyclerView.setVisibility(View.GONE);
        emptyLayout.setVisibility(View.VISIBLE);
    }
}
