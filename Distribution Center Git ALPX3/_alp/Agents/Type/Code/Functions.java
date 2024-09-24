int getSize()
{/*ALCODESTART::1417692828492*/
int size = 0;
for (PalletRack p : palletRacks) {
	size += p.size();	
}
return size;
/*ALCODEEND*/}

Pallet getPallet(Order order)
{/*ALCODESTART::1417693092940*/
Pallet p = null;

for (PalletRack pR : palletRacks) {
	for (int i = 0; i < pR.size(); i++) {
		Pallet cp = (Pallet) pR.getByIndex(i);
		if (!cp.reserved) {
			p = cp;
			break;
		}
	}
	if (p != null)
		break;
}

p.reserved = true;
return p;
/*ALCODEEND*/}

int nFree()
{/*ALCODESTART::1417788064850*/
return getSize() - reserved;
/*ALCODEEND*/}

PalletRack putPallet()
{/*ALCODESTART::1418287765905*/
int reserve = reservedCells;

for (PalletRack pR : palletRacks) {
	int n = pR.capacity() - pR.size() - pR.reserved();
	if( n > reserve ) return pR;
	else reserve -= n;
}

return null;
/*ALCODEEND*/}

int getCapacity()
{/*ALCODESTART::1418768728851*/
int capacity = 0;
for (PalletRack p : palletRacks) {
	capacity += p.capacity();	
}
return capacity;
/*ALCODEEND*/}

