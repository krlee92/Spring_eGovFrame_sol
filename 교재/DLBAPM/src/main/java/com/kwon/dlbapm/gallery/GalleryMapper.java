package com.kwon.dlbapm.gallery;

import java.util.List;

public interface GalleryMapper {
	public abstract int delete(GalleryFile gf);

	public abstract List<GalleryFile> get();

	public abstract int upload(GalleryFile gf);
}
