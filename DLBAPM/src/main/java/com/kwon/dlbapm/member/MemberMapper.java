package com.kwon.dlbapm.member;

public interface MemberMapper {
	public abstract int bye(Member m);
	public abstract Member getMemberByID(Member m);
	public abstract int join(Member m);
	public abstract int update(Member m);
}
