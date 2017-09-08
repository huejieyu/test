package helloWorld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

	public class HelloWorld extends AbstractVerticle {

		@Override
		public void start() throws Exception {
			Router router = Router.router(vertx);
			router.route().handler(
					routingContext -> {
						routingContext.response()
								.putHeader("content-type", "text/html")
								.end("hello world. By Huajieyu");
					});

			vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		}
		public static void main(String[] args) {
			Vertx vertx = Vertx.vertx();
			vertx.deployVerticle(new HelloWorld());
		}
	}

