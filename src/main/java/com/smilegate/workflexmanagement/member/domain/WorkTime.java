package com.smilegate.workflexmanagement.member.domain;

import com.smilegate.workflexmanagement.member.domain.Member.MemberId;
import java.time.LocalDateTime;
import lombok.Value;

@Value
public class WorkTime {

    WorkTimeId id;

    MemberId memberId;

    LocalDateTime startDateTime;

    LocalDateTime endDateTime;

    @Value
    public static class WorkTimeId {
        Long value;
    }
}
