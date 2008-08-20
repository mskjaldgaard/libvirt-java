package org.libvirt;

public class StorageVolInfo {

	/**
	 * The type of the Volume
	 */
	public VirStorageVolType type;
	/**
	 * Logical size bytes
	 */
	public long	capacity;
	/**
	 * Current allocation bytes
	 */
	public long	allocation;

	public static enum VirStorageVolType{
		/**
		 * Regular file based volumes
		 */
		VIR_STORAGE_VOL_FILE,
		/**
		 * Block based volumes
		 */
		VIR_STORAGE_VOL_BLOCK
	};

	/**
	 * This is meant to be called from the JNI side, as a convenience constructor
	 *
	 * @param type the type, as defined by libvirt
	 * @param capacity
	 * @param allocation
	 */
	StorageVolInfo(int type, long capacity, long allocation){
		switch(type){
			case 0: this.type=VirStorageVolType.VIR_STORAGE_VOL_FILE; break;
			case 1: this.type=VirStorageVolType.VIR_STORAGE_VOL_BLOCK; break;
			default: assert(false);
		}
		this.capacity = capacity;
		this.allocation = allocation;
	}

	public String toString(){
		StringBuffer result = new StringBuffer("");
		result.append("type:" + type + "\n");
		result.append("capacity:" + capacity + "\n");
		result.append("allocation:" + allocation + "\n");
		return result.toString();
	}
}
