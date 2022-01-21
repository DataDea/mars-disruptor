package event;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2022/1/21 11:03
 */
public class DittoEventFactory implements AbstractEventFactory<DittoEvent>{

    @Override
    public DittoEvent newInstance() {
        return DittoEvent.INSTANCE;
    }
}
