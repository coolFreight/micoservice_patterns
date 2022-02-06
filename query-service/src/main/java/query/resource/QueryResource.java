package query.resource;

import graphql.GraphQL;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller("/query")
public class QueryResource {

    private static final Logger LOGGER = getLogger(QueryResource.class);

    private GraphQL graphQL;


    public QueryResource() {
    }

    public QueryResource(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

//    public QueryResource(QueryPracticeRepository repo) {
//        this.repo = repo;
//    }

    private static final String QUERY = "" +
            "    subscription StockCodeSubscription {\n" +
            "        stockQuotes(stockCode:\"IBM') {\n" +
            "            dateTime\n" +
            "            stockCode\n" +
            "            stockPrice\n" +
            "            stockPriceChange\n" +
            "        }\n" +
            "    }\n";

    @Post(consumes = MediaType.TEXT_PLAIN)
    public List<String> createTinyUrl(String createTinyUrl) {


        return null;
    }
}
