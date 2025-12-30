package com.rahman.openstackshard.ui;

import java.util.ArrayList;
import java.util.List;

import org.openstack4j.api.OSClient.OSClientV3;
import org.openstack4j.model.image.v2.Image;
import org.openstack4j.openstack.OSFactory;

import com.rahman.arctic.shard.shards.ShardProviderUICreation;
import com.rahman.arctic.shard.shards.UIField;
import com.rahman.openstackshard.objects.OpenStackProviderItem;

public class ObtainOS extends ShardProviderUICreation<OSClientV3, List<OpenStackProviderItem>> {

	@UIField(key = "osId", label = "Openstack Image")
	public List<OpenStackProviderItem> returnResult(OSClientV3 client) {
		List<OpenStackProviderItem> images = new ArrayList<>();
        List<? extends Image> osImages = OSFactory.clientFromToken(client.getToken()).imagesV2().list();
        osImages.forEach(e -> {
            images.add(new OpenStackProviderItem(e.getId(), e.getName()));
        });
        return images;
	}

}