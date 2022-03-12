package com.koing.one.one;

// 소지품
public class Bag {
    private Long amount; // 현금
    private Invitation invitation; // 초대장
    private Ticket ticket; // 티켓

    // 이벤트 당첨이 되지 않았을 경우 현금만 가지고 있다.
    public Bag(long amount) {
        this.amount = amount;
    }

    // 이벤트 당첨이 되었을 경우 현금+초대장을 가지고 있다.
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
