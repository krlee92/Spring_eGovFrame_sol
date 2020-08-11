package com.kwon.dlbapm.dr;

import java.util.List;

public interface DRMapper {
	public abstract int delete(DRFile df);
	public abstract int upload(DRFile df);
	public abstract List<DRFile> getFile(DRFile df);
	public abstract DRFile getFileByNo(DRFile df);
}
