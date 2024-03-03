package com.smilegate.workflexmanagement.member.domain;

import lombok.Value;

@Value
public class Member {

    MemberId id;

    WorkTimeWindow workTimeWindow;

    @Value
    public static class MemberId {
        Long value;
    }
}
