package event;

import com.lmax.disruptor.EventTranslator;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yanghai10
 * @ClassName
 * @Description
 * @date 2022/1/21 10:43
 */
public abstract class AbstractEvent implements Serializable, EventTranslator {

    private static final long serialVersionUID = -5813661853267102348L;

    private String eventId;

    private String source;

    private Date time;
}
