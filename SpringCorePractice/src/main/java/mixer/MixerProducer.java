package mixer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myvalidator.CheckIDFormat;
import myvalidator.CheckNameFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MixerProducer {

    @NotNull
    @CheckNameFormat
    private String producerName;

    @NotNull
    @Past(message = "Incorrect date! \nDate must be in past time!")
    private LocalDate produceDate;

    @NotNull
    @CheckIDFormat
    private String idMixer;
}
