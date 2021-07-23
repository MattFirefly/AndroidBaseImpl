package com.gm.q.example.ui.markdown;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ResourceUtils;
import com.gm.q.example.databinding.FragmentMarkDownBinding;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import io.noties.markwon.Markwon;
import io.noties.markwon.app.readme.GrammarLocatorDef;
import io.noties.markwon.ext.latex.JLatexMathPlugin;
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.ext.tables.TableTheme;
import io.noties.markwon.ext.tasklist.TaskListPlugin;
import io.noties.markwon.html.HtmlPlugin;
import io.noties.markwon.image.ImagesPlugin;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import io.noties.markwon.linkify.LinkifyPlugin;
import io.noties.markwon.syntax.Prism4jThemeDefault;
import io.noties.markwon.syntax.SyntaxHighlightPlugin;
import io.noties.prism4j.Prism4j;

public class MarkDownFragment extends Fragment {

    public static final String FILE_NAME = "FileName";
    public String file;
    private FragmentMarkDownBinding binding;
    private MarkDownViewModel markDownViewModel;

    public static MarkDownFragment newInstance(String file) {
        MarkDownFragment fragment = new MarkDownFragment();
        Bundle args = new Bundle();
        args.putString(FILE_NAME, file);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            file = getArguments().getString(FILE_NAME);
        }
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        String s = ResourceUtils.readAssets2String(file);


        Context context = getContext();
        markDownViewModel = new ViewModelProvider(this).get(MarkDownViewModel.class);
        binding = FragmentMarkDownBinding.inflate(inflater, container, false);

        final Markwon markwon = Markwon.builder(context)
                //Highlight
                .usePlugin(SyntaxHighlightPlugin.create(new Prism4j(new GrammarLocatorDef()), Prism4jThemeDefault.create(0)))
                //linkify
                .usePlugin(LinkifyPlugin.create())
                //inline
                .usePlugin(MarkwonInlineParserPlugin.create())
                //image
                .usePlugin(ImagesPlugin.create())
                //html
                .usePlugin(HtmlPlugin.create())
                //tasklist
                .usePlugin(TaskListPlugin.create(context))
                //tables
                .usePlugin(TablePlugin.create(context))
                //.usePlugin(TablePlugin.create(caratetableTheme()))
                //strikethrough
                .usePlugin(StrikethroughPlugin.create())
                //latex
                .usePlugin(MarkwonInlineParserPlugin.create())
                .usePlugin(JLatexMathPlugin.create(binding.text.getTextSize(), builder -> {
                    builder.inlinesEnabled(true); // ENABLE inlines
                }))
                .build();
        markwon.setMarkdown(binding.text, s);
//        markDownViewModel.getText().observe(getViewLifecycleOwner(), s -> {
//            final Markwon markwon = Markwon.builder(context).usePlugin(GlideImagesPlugin.create(context)).build();
//            markwon.setMarkdown(binding.text, s);
//        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public TableTheme caratetableTheme() {
        return new TableTheme.Builder()
//                .tableBorderColor(Color.RED)
//                .tableBorderWidth(1)
//                .tableCellPadding(8)
//                .tableHeaderRowBackgroundColor(Color.BLACK)
//                .tableEvenRowBackgroundColor(Color.GREEN)
//                .tableOddRowBackgroundColor(Color.YELLOW)
                .build();
    }
}