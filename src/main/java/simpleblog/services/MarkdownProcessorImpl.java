package simpleblog.services;

import org.markdown4j.Markdown4jProcessor;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by marc on 12/07/15.
 */
@Service
public class MarkdownProcessorImpl implements MarkdownProcessor {

    Markdown4jProcessor processor;

    public MarkdownProcessorImpl()
    {
        processor = new Markdown4jProcessor();
    }

    public String getHtml(String markdown) {

        try
        {
            return processor
                    .process(markdown)
                    .replaceAll("<pre>", "<pre class=\"prettyprint\">");
        }
        catch (IOException e)
        {
            return "Could not parse markdown code : " + e.getMessage();
        }

    }
}
