import java.util.Objects;

public class JUnitObjectAcceptorThread<T> extends Thread {

  public interface ObjectAcceptor<T> {
    void accept(T object) throws Exception;
  }

  public interface ExceptionHandler {
    void handle(Throwable t);

    static ExceptionHandler uncheckedWrapper() {
      return e -> {
        throw new RuntimeException(e);
      };
    }
  }

  private final T object;
  private final ObjectAcceptor<? super T> acceptor;
  private final ExceptionHandler failureHandler;

  public JUnitObjectAcceptorThread(T object, ObjectAcceptor<? super T> acceptor) {
    this(object, acceptor, ExceptionHandler.uncheckedWrapper());
  }

  public JUnitObjectAcceptorThread(T object, ObjectAcceptor<? super T> acceptor, ExceptionHandler exceptionHandler) {
    this.object = Objects.requireNonNull(object, "object must not be null");
    this.acceptor = Objects.requireNonNull(acceptor, "acceptor must not be null");
    this.failureHandler = Objects.requireNonNull(exceptionHandler, "exceptionHandler must not be null");
  }

  @Override
  public void run() {
    try {
      acceptor.accept(object);
    } catch (Exception e) {
      failureHandler.handle(e);
    }
  }

  public void unsafeJoin() {
    try {
      join();
    } catch (InterruptedException e) {
      failureHandler.handle(e);
    }
  }

}
