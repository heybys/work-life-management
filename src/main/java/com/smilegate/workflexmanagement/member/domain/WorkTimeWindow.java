package com.smilegate.workflexmanagement.member.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.NonNull;
import lombok.Value;

@Value
public class WorkTimeWindow {

    @NonNull
    List<WorkTime> workTimes;

    public WorkTimeWindow(@NonNull List<WorkTime> workTimes) {
        this.workTimes = workTimes;
    }

    public WorkTimeWindow(@NonNull WorkTime... workTimes) {
        this.workTimes = new ArrayList<>(Arrays.asList(workTimes));
    }

    public List<WorkTime> getWorkTimes(LocalDate baseDate) {
        LocalDateTime startOfDay = baseDate.atStartOfDay();
        LocalDateTime endOfDay = baseDate.plusDays(1L).atStartOfDay();

        List<WorkTime> filteredWorkTimes = new ArrayList<>();
        for (WorkTime workTime : this.workTimes) {

            LocalDateTime dateTime = workTime.getStartDateTime();

            if (!dateTime.isBefore(startOfDay) && dateTime.isBefore(endOfDay)) {
                filteredWorkTimes.add(workTime);
            }
        }
        return filteredWorkTimes;
    }
}
