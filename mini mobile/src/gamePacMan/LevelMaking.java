package gamePacMan;

import java.awt.Color;
import java.awt.Graphics;

public class LevelMaking {

	public static boolean[] vis = new boolean[432];
	public static boolean[] value = new boolean[432];
	public static int[][] para = new int[432][4];

	public LevelMaking() {
		for (int i = 0; i < 432; i++) {
			vis[i] = false;
			value[i] = false;
		}

	}

	public LevelMaking(int l) {
		for (int i = 0; i < 432; i++) {
			vis[i] = false;
			value[i] = false;
		}

		if (l == 1)
			makeLevelOne();
		else if (l == 2)
			makeLevelTwo();
		else if (l == 3)
			makeLevelThree();
		else if (l == 4)
			makeLevelFour();
		else if (l == 5)
			makeLevelFive();
		else if (l == 6)
			makeLevelsix();
		else if (l == 7)
			makeLevelseven();
		else if (l == 8)
			makeLeveleight();
		else if (l == 9)
			makeLevelnine();
		else if (l == 10)
			makeLevelten();

		for (int i = 0; i < 432; i++) {
			if (vis[i])
				value[i] = true;
		}
		value[24 * 16 + 1] = true;
		value[46] = true;
		value[69] = true;
		value[70] = true;
		value[94] = true;

		para = makeBFSarray(vis, 24, 18);

	}

	private void makeLevelsix() {
		// TODO Auto-generated method stub
		vis[17] = true;
		vis[18] = true;
		vis[19] = true;
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[26] = true;
		vis[27] = true;
		vis[28] = true;
		vis[29] = true;
		vis[30] = true;
		vis[32] = true;
		vis[33] = true;
		vis[34] = true;
		vis[35] = true;
		vis[45] = true;
		vis[47] = true;
		vis[49] = true;
		vis[50] = true;
		vis[54] = true;
		vis[56] = true;
		vis[59] = true;
		vis[61] = true;
		vis[62] = true;
		vis[63] = true;
		vis[71] = true;
		vis[74] = true;
		vis[76] = true;
		vis[78] = true;
		vis[80] = true;
		vis[82] = true;
		vis[83] = true;
		vis[85] = true;
		vis[89] = true;
		vis[90] = true;
		vis[93] = true;
		vis[95] = true;
		vis[96] = true;
		vis[98] = true;
		vis[100] = true;
		vis[102] = true;
		vis[104] = true;
		vis[109] = true;
		vis[114] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[122] = true;
		vis[128] = true;
		vis[130] = true;
		vis[131] = true;
		vis[133] = true;
		vis[134] = true;
		vis[135] = true;
		vis[136] = true;
		vis[137] = true;
		vis[138] = true;
		vis[145] = true;
		vis[146] = true;
		vis[152] = true;
		vis[155] = true;
		vis[159] = true;
		vis[164] = true;
		vis[165] = true;
		vis[166] = true;
		vis[170] = true;
		vis[172] = true;
		vis[173] = true;
		vis[174] = true;
		vis[179] = true;
		vis[192] = true;
		vis[194] = true;
		vis[196] = true;
		vis[198] = true;
		vis[200] = true;
		vis[201] = true;
		vis[202] = true;
		vis[203] = true;
		vis[204] = true;
		vis[205] = true;
		vis[206] = true;
		vis[208] = true;
		vis[209] = true;
		vis[211] = true;
		vis[213] = true;
		vis[214] = true;
		vis[218] = true;
		vis[222] = true;
		vis[227] = true;
		vis[232] = true;
		vis[233] = true;
		vis[237] = true;
		vis[238] = true;
		vis[242] = true;
		vis[243] = true;
		vis[244] = true;
		vis[245] = true;
		vis[246] = true;
		vis[251] = true;
		vis[253] = true;
		vis[256] = true;
		vis[258] = true;
		vis[260] = true;
		vis[262] = true;
		vis[265] = true;
		vis[272] = true;
		vis[275] = true;
		vis[280] = true;
		vis[283] = true;
		vis[286] = true;
		vis[292] = true;
		vis[293] = true;
		vis[294] = true;
		vis[297] = true;
		vis[300] = true;
		vis[302] = true;
		vis[303] = true;
		vis[304] = true;
		vis[310] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[327] = true;
		vis[328] = true;
		vis[334] = true;
		vis[336] = true;
		vis[338] = true;
		vis[340] = true;
		vis[341] = true;
		vis[342] = true;
		vis[344] = true;
		vis[345] = true;
		vis[346] = true;
		vis[347] = true;
		vis[349] = true;
		vis[351] = true;
		vis[352] = true;
		vis[354] = true;
		vis[355] = true;
		vis[356] = true;
		vis[358] = true;
		vis[360] = true;
		vis[364] = true;
		vis[371] = true;
		vis[373] = true;
		vis[375] = true;
		vis[376] = true;
		vis[379] = true;
		vis[382] = true;
		vis[384] = true;
		vis[386] = true;
		vis[388] = true;
		vis[389] = true;
		vis[390] = true;
		vis[391] = true;
		vis[392] = true;
		vis[393] = true;
		vis[395] = true;
		vis[397] = true;
		vis[399] = true;
		vis[400] = true;
		vis[406] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
		vis[417] = true;
		vis[419] = true;
		vis[421] = true;
		vis[426] = true;
		vis[427] = true;
		vis[428] = true;
	}

	private void makeLevelseven() {
		// TODO Auto-generated method stub
		vis[2] = true;
		vis[5] = true;
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[32] = true;
		vis[33] = true;
		vis[38] = true;
		vis[39] = true;
		vis[41] = true;
		vis[43] = true;
		vis[45] = true;
		vis[47] = true;
		vis[49] = true;
		vis[51] = true;
		vis[52] = true;
		vis[54] = true;
		vis[56] = true;
		vis[59] = true;
		vis[60] = true;
		vis[65] = true;
		vis[71] = true;
		vis[73] = true;
		vis[78] = true;
		vis[88] = true;
		vis[89] = true;
		vis[90] = true;
		vis[93] = true;
		vis[95] = true;
		vis[98] = true;
		vis[101] = true;
		vis[105] = true;
		vis[106] = true;
		vis[109] = true;
		vis[110] = true;
		vis[113] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[121] = true;
		vis[123] = true;
		vis[124] = true;
		vis[128] = true;
		vis[135] = true;
		vis[139] = true;
		vis[140] = true;
		vis[141] = true;
		vis[142] = true;
		vis[143] = true;
		vis[145] = true;
		vis[151] = true;
		vis[160] = true;
		vis[163] = true;
		vis[167] = true;
		vis[172] = true;
		vis[175] = true;
		vis[178] = true;
		vis[179] = true;
		vis[180] = true;
		vis[181] = true;
		vis[184] = true;
		vis[187] = true;
		vis[189] = true;
		vis[191] = true;
		vis[192] = true;
		vis[193] = true;
		vis[194] = true;
		vis[195] = true;
		vis[196] = true;
		vis[197] = true;
		vis[199] = true;
		vis[203] = true;
		vis[204] = true;
		vis[208] = true;
		vis[211] = true;
		vis[213] = true;
		vis[224] = true;
		vis[231] = true;
		vis[235] = true;
		vis[237] = true;
		vis[238] = true;
		vis[240] = true;
		vis[241] = true;
		vis[242] = true;
		vis[243] = true;
		vis[244] = true;
		vis[245] = true;
		vis[249] = true;
		vis[254] = true;
		vis[257] = true;
		vis[259] = true;
		vis[268] = true;
		vis[271] = true;
		vis[274] = true;
		vis[277] = true;
		vis[280] = true;
		vis[281] = true;
		vis[283] = true;
		vis[284] = true;
		vis[286] = true;
		vis[292] = true;
		vis[294] = true;
		vis[295] = true;
		vis[296] = true;
		vis[299] = true;
		vis[300] = true;
		vis[304] = true;
		vis[305] = true;
		vis[308] = true;
		vis[310] = true;
		vis[311] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[316] = true;
		vis[332] = true;
		vis[335] = true;
		vis[336] = true;
		vis[338] = true;
		vis[343] = true;
		vis[345] = true;
		vis[346] = true;
		vis[347] = true;
		vis[348] = true;
		vis[349] = true;
		vis[350] = true;
		vis[351] = true;
		vis[352] = true;
		vis[353] = true;
		vis[354] = true;
		vis[356] = true;
		vis[357] = true;
		vis[359] = true;
		vis[360] = true;
		vis[364] = true;
		vis[365] = true;
		vis[366] = true;
		vis[367] = true;
		vis[369] = true;
		vis[378] = true;
		vis[381] = true;
		vis[383] = true;
		vis[384] = true;
		vis[386] = true;
		vis[391] = true;
		vis[392] = true;
		vis[393] = true;
		vis[395] = true;
		vis[396] = true;
		vis[398] = true;
		vis[399] = true;
		vis[400] = true;
		vis[402] = true;
		vis[403] = true;
		vis[405] = true;
		vis[407] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
		vis[413] = true;
		vis[419] = true;
		vis[426] = true;
		vis[427] = true;
		vis[431] = true;
	}

	private void makeLeveleight() {
		// TODO Auto-generated method stub

	}

	private void makeLevelnine() {
		// TODO Auto-generated method stub

	}

	private void makeLevelten() {
		// TODO Auto-generated method stub

	}

	public void drawLevel(Graphics g) {

		drawBoxs(g);
		drawKhabar(g);

	}

	private void drawKhabar(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		for (int i = 0; i < 432; i++)
			if (!value[i]) {
				g.fillRect(300 + (i % 24) * 20 + 8, 10 + (i / 24) * 20 + 8, 4, 4);
			}
	}

	private void drawBoxs(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.RED);
		for (int i = 0; i < 432; i++)
			if (vis[i]) {
				g.fillRect(300 + (i % 24) * 20, 10 + (i / 24) * 20, 20, 20);
			}
	}

	public int[][] makeBFSarray(boolean[] vis, int x, int y) {
		int z = x * y;
		int[][] r = new int[z][4];
		int assignedValue = -1;

		for (int i = 0; i < z; i++) {
			if (!vis[i]) {

				if (i % x != 0 && !vis[i - 1]) {
					r[i][0] = i - 1;
				} else {
					r[i][0] = assignedValue;
				}

				if (i > 23 && !vis[i - x]) {
					r[i][1] = i - x;
				} else {
					r[i][1] = assignedValue;
				}

				if (i % x != x - 1 && !vis[i + 1]) {
					r[i][2] = i + 1;
				} else {
					r[i][2] = assignedValue;
				}

				if (i < z - 24 && !vis[i + x]) {
					r[i][3] = i + x;
				} else {
					r[i][3] = assignedValue;
				}

			} else {
				for (int j = 0; j < 4; j++)
					r[i][j] = assignedValue;
			}
		}

		/*
		 * for (int i = 0; i < z; i++) { System.out.print(i + "   "); for (int j
		 * = 0; j < 4; j++) { System.out.print(r[i][j] + " "); }
		 * System.out.println(); }
		 */
		return r;
	}

	private void makeLevelOne() {
		// TODO Auto-generated method stub
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[25] = true;
		vis[26] = true;
		vis[28] = true;
		vis[29] = true;
		vis[45] = true;
		vis[47] = true;
		vis[49] = true;
		vis[53] = true;
		vis[71] = true;
		vis[75] = true;
		vis[93] = true;
		vis[95] = true;
		vis[97] = true;
		vis[101] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[121] = true;
		vis[122] = true;
		vis[124] = true;
		vis[125] = true;
		vis[153] = true;
		vis[154] = true;
		vis[157] = true;
		vis[158] = true;
		vis[177] = true;
		vis[182] = true;
		vis[203] = true;
		vis[204] = true;
		vis[227] = true;
		vis[228] = true;
		vis[249] = true;
		vis[254] = true;
		vis[273] = true;
		vis[274] = true;
		vis[277] = true;
		vis[278] = true;
		vis[306] = true;
		vis[307] = true;
		vis[309] = true;
		vis[310] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[330] = true;
		vis[334] = true;
		vis[336] = true;
		vis[338] = true;
		vis[356] = true;
		vis[360] = true;
		vis[378] = true;
		vis[382] = true;
		vis[384] = true;
		vis[386] = true;
		vis[402] = true;
		vis[403] = true;
		vis[405] = true;
		vis[406] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
	}

	private void makeLevelTwo() {
		// TODO Auto-generated method stub
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[25] = true;
		vis[26] = true;
		vis[27] = true;
		vis[28] = true;
		vis[45] = true;
		vis[47] = true;
		vis[49] = true;
		vis[71] = true;
		vis[73] = true;
		vis[75] = true;
		vis[76] = true;
		vis[79] = true;
		vis[81] = true;
		vis[82] = true;
		vis[83] = true;
		vis[84] = true;
		vis[85] = true;
		vis[86] = true;
		vis[88] = true;
		vis[93] = true;
		vis[95] = true;
		vis[97] = true;
		vis[99] = true;
		vis[100] = true;
		vis[103] = true;
		vis[112] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[127] = true;
		vis[129] = true;
		vis[131] = true;
		vis[132] = true;
		vis[134] = true;
		vis[136] = true;
		vis[151] = true;
		vis[153] = true;
		vis[158] = true;
		vis[160] = true;
		vis[170] = true;
		vis[172] = true;
		vis[175] = true;
		vis[177] = true;
		vis[179] = true;
		vis[180] = true;
		vis[182] = true;
		vis[184] = true;
		vis[187] = true;
		vis[189] = true;
		vis[195] = true;
		vis[199] = true;
		vis[201] = true;
		vis[203] = true;
		vis[204] = true;
		vis[206] = true;
		vis[208] = true;
		vis[212] = true;
		vis[218] = true;
		vis[220] = true;
		vis[223] = true;
		vis[225] = true;
		vis[230] = true;
		vis[232] = true;
		vis[235] = true;
		vis[237] = true;
		vis[247] = true;
		vis[249] = true;
		vis[251] = true;
		vis[252] = true;
		vis[254] = true;
		vis[256] = true;
		vis[271] = true;
		vis[280] = true;
		vis[295] = true;
		vis[297] = true;
		vis[298] = true;
		vis[299] = true;
		vis[300] = true;
		vis[301] = true;
		vis[302] = true;
		vis[304] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[331] = true;
		vis[332] = true;
		vis[334] = true;
		vis[336] = true;
		vis[338] = true;
		vis[343] = true;
		vis[344] = true;
		vis[345] = true;
		vis[346] = true;
		vis[347] = true;
		vis[348] = true;
		vis[349] = true;
		vis[350] = true;
		vis[351] = true;
		vis[352] = true;
		vis[355] = true;
		vis[356] = true;
		vis[358] = true;
		vis[360] = true;
		vis[382] = true;
		vis[384] = true;
		vis[386] = true;
		vis[403] = true;
		vis[404] = true;
		vis[405] = true;
		vis[406] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
	}

	private void makeLevelThree() {
		// TODO Auto-generated method stub
		vis[7] = true;
		vis[8] = true;
		vis[9] = true;
		vis[10] = true;
		vis[11] = true;
		vis[12] = true;
		vis[13] = true;
		vis[14] = true;
		vis[15] = true;
		vis[16] = true;
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[25] = true;
		vis[26] = true;
		vis[27] = true;
		vis[29] = true;
		vis[42] = true;
		vis[45] = true;
		vis[47] = true;
		vis[49] = true;
		vis[53] = true;
		vis[55] = true;
		vis[56] = true;
		vis[57] = true;
		vis[58] = true;
		vis[59] = true;
		vis[60] = true;
		vis[61] = true;
		vis[62] = true;
		vis[63] = true;
		vis[64] = true;
		vis[66] = true;
		vis[71] = true;
		vis[73] = true;
		vis[75] = true;
		vis[77] = true;
		vis[90] = true;
		vis[93] = true;
		vis[95] = true;
		vis[97] = true;
		vis[99] = true;
		vis[101] = true;
		vis[103] = true;
		vis[105] = true;
		vis[110] = true;
		vis[112] = true;
		vis[114] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[123] = true;
		vis[125] = true;
		vis[127] = true;
		vis[131] = true;
		vis[132] = true;
		vis[136] = true;
		vis[138] = true;
		vis[145] = true;
		vis[146] = true;
		vis[147] = true;
		vis[149] = true;
		vis[151] = true;
		vis[153] = true;
		vis[158] = true;
		vis[160] = true;
		vis[162] = true;
		vis[171] = true;
		vis[173] = true;
		vis[175] = true;
		vis[177] = true;
		vis[179] = true;
		vis[180] = true;
		vis[182] = true;
		vis[184] = true;
		vis[186] = true;
		vis[188] = true;
		vis[189] = true;
		vis[190] = true;
		vis[193] = true;
		vis[195] = true;
		vis[197] = true;
		vis[199] = true;
		vis[201] = true;
		vis[203] = true;
		vis[204] = true;
		vis[206] = true;
		vis[208] = true;
		vis[210] = true;
		vis[212] = true;
		vis[217] = true;
		vis[219] = true;
		vis[221] = true;
		vis[223] = true;
		vis[225] = true;
		vis[230] = true;
		vis[232] = true;
		vis[234] = true;
		vis[236] = true;
		vis[238] = true;
		vis[241] = true;
		vis[245] = true;
		vis[247] = true;
		vis[251] = true;
		vis[252] = true;
		vis[256] = true;
		vis[258] = true;
		vis[260] = true;
		vis[262] = true;
		vis[265] = true;
		vis[266] = true;
		vis[267] = true;
		vis[269] = true;
		vis[271] = true;
		vis[273] = true;
		vis[278] = true;
		vis[280] = true;
		vis[282] = true;
		vis[284] = true;
		vis[286] = true;
		vis[293] = true;
		vis[295] = true;
		vis[304] = true;
		vis[306] = true;
		vis[308] = true;
		vis[310] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[317] = true;
		vis[319] = true;
		vis[321] = true;
		vis[322] = true;
		vis[323] = true;
		vis[324] = true;
		vis[325] = true;
		vis[326] = true;
		vis[328] = true;
		vis[330] = true;
		vis[334] = true;
		vis[336] = true;
		vis[338] = true;
		vis[356] = true;
		vis[357] = true;
		vis[358] = true;
		vis[360] = true;
		vis[366] = true;
		vis[367] = true;
		vis[368] = true;
		vis[369] = true;
		vis[370] = true;
		vis[371] = true;
		vis[372] = true;
		vis[373] = true;
		vis[374] = true;
		vis[375] = true;
		vis[376] = true;
		vis[377] = true;
		vis[381] = true;
		vis[382] = true;
		vis[384] = true;
		vis[386] = true;
		vis[406] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
		vis[412] = true;
		vis[413] = true;
		vis[414] = true;
		vis[415] = true;
		vis[416] = true;
		vis[417] = true;
		vis[418] = true;
		vis[419] = true;
		vis[420] = true;
		vis[421] = true;
		vis[422] = true;
		vis[423] = true;
		vis[424] = true;
		vis[425] = true;
		vis[426] = true;
		vis[427] = true;
	}

	private void makeLevelFour() {
		// TODO Auto-generated method stub
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[25] = true;
		vis[26] = true;
		vis[27] = true;
		vis[28] = true;
		vis[29] = true;
		vis[30] = true;
		vis[31] = true;
		vis[33] = true;
		vis[34] = true;
		vis[36] = true;
		vis[37] = true;
		vis[38] = true;
		vis[39] = true;
		vis[40] = true;
		vis[41] = true;
		vis[42] = true;
		vis[43] = true;
		vis[45] = true;
		vis[47] = true;
		vis[49] = true;
		vis[71] = true;
		vis[73] = true;
		vis[75] = true;
		vis[76] = true;
		vis[78] = true;
		vis[79] = true;
		vis[80] = true;
		vis[82] = true;
		vis[83] = true;
		vis[84] = true;
		vis[85] = true;
		vis[86] = true;
		vis[87] = true;
		vis[88] = true;
		vis[90] = true;
		vis[91] = true;
		vis[93] = true;
		vis[95] = true;
		vis[97] = true;
		vis[99] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[123] = true;
		vis[125] = true;
		vis[126] = true;
		vis[127] = true;
		vis[129] = true;
		vis[130] = true;
		vis[131] = true;
		vis[132] = true;
		vis[134] = true;
		vis[135] = true;
		vis[136] = true;
		vis[137] = true;
		vis[138] = true;
		vis[139] = true;
		vis[142] = true;
		vis[143] = true;
		vis[145] = true;
		vis[147] = true;
		vis[149] = true;
		vis[167] = true;
		vis[169] = true;
		vis[171] = true;
		vis[173] = true;
		vis[175] = true;
		vis[176] = true;
		vis[177] = true;
		vis[178] = true;
		vis[179] = true;
		vis[181] = true;
		vis[182] = true;
		vis[183] = true;
		vis[184] = true;
		vis[186] = true;
		vis[187] = true;
		vis[188] = true;
		vis[189] = true;
		vis[193] = true;
		vis[197] = true;
		vis[217] = true;
		vis[219] = true;
		vis[223] = true;
		vis[225] = true;
		vis[227] = true;
		vis[228] = true;
		vis[229] = true;
		vis[230] = true;
		vis[232] = true;
		vis[233] = true;
		vis[234] = true;
		vis[235] = true;
		vis[237] = true;
		vis[238] = true;
		vis[239] = true;
		vis[241] = true;
		vis[243] = true;
		vis[245] = true;
		vis[247] = true;
		vis[249] = true;
		vis[265] = true;
		vis[267] = true;
		vis[269] = true;
		vis[271] = true;
		vis[273] = true;
		vis[275] = true;
		vis[276] = true;
		vis[277] = true;
		vis[279] = true;
		vis[280] = true;
		vis[281] = true;
		vis[282] = true;
		vis[283] = true;
		vis[284] = true;
		vis[286] = true;
		vis[287] = true;
		vis[293] = true;
		vis[297] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[317] = true;
		vis[319] = true;
		vis[323] = true;
		vis[325] = true;
		vis[326] = true;
		vis[327] = true;
		vis[328] = true;
		vis[329] = true;
		vis[330] = true;
		vis[332] = true;
		vis[333] = true;
		vis[334] = true;
		vis[335] = true;
		vis[336] = true;
		vis[338] = true;
		vis[343] = true;
		vis[345] = true;
		vis[347] = true;
		vis[349] = true;
		vis[360] = true;
		vis[365] = true;
		vis[367] = true;
		vis[369] = true;
		vis[371] = true;
		vis[373] = true;
		vis[375] = true;
		vis[377] = true;
		vis[378] = true;
		vis[379] = true;
		vis[380] = true;
		vis[381] = true;
		vis[382] = true;
		vis[384] = true;
		vis[386] = true;
		vis[389] = true;
		vis[393] = true;
		vis[395] = true;
		vis[399] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
		vis[411] = true;
		vis[415] = true;
		vis[417] = true;
		vis[419] = true;
		vis[421] = true;
		vis[423] = true;
		vis[425] = true;
		vis[426] = true;
		vis[427] = true;
		vis[428] = true;
		vis[430] = true;
		vis[431] = true;
	}

	private void makeLevelFive() {
		// TODO Auto-generated method stub
		vis[3] = true;
		vis[7] = true;
		vis[9] = true;
		vis[14] = true;
		vis[18] = true;
		vis[21] = true;
		vis[22] = true;
		vis[23] = true;
		vis[25] = true;
		vis[27] = true;
		vis[29] = true;
		vis[31] = true;
		vis[33] = true;
		vis[34] = true;
		vis[36] = true;
		vis[38] = true;
		vis[39] = true;
		vis[40] = true;
		vis[45] = true;
		vis[47] = true;
		vis[51] = true;
		vis[53] = true;
		vis[55] = true;
		vis[57] = true;
		vis[58] = true;
		vis[64] = true;
		vis[66] = true;
		vis[71] = true;
		vis[81] = true;
		vis[84] = true;
		vis[88] = true;
		vis[90] = true;
		vis[93] = true;
		vis[95] = true;
		vis[96] = true;
		vis[97] = true;
		vis[98] = true;
		vis[99] = true;
		vis[100] = true;
		vis[101] = true;
		vis[103] = true;
		vis[105] = true;
		vis[107] = true;
		vis[109] = true;
		vis[112] = true;
		vis[114] = true;
		vis[117] = true;
		vis[118] = true;
		vis[119] = true;
		vis[127] = true;
		vis[129] = true;
		vis[131] = true;
		vis[134] = true;
		vis[136] = true;
		vis[138] = true;
		vis[144] = true;
		vis[145] = true;
		vis[147] = true;
		vis[148] = true;
		vis[149] = true;
		vis[150] = true;
		vis[151] = true;
		vis[153] = true;
		vis[154] = true;
		vis[156] = true;
		vis[160] = true;
		vis[172] = true;
		vis[184] = true;
		vis[186] = true;
		vis[194] = true;
		vis[197] = true;
		vis[199] = true;
		vis[200] = true;
		vis[201] = true;
		vis[202] = true;
		vis[203] = true;
		vis[204] = true;
		vis[205] = true;
		vis[206] = true;
		vis[207] = true;
		vis[208] = true;
		vis[210] = true;
		vis[211] = true;
		vis[212] = true;
		vis[213] = true;
		vis[214] = true;
		vis[215] = true;
		vis[216] = true;
		vis[221] = true;
		vis[239] = true;
		vis[241] = true;
		vis[247] = true;
		vis[248] = true;
		vis[249] = true;
		vis[250] = true;
		vis[252] = true;
		vis[253] = true;
		vis[254] = true;
		vis[255] = true;
		vis[256] = true;
		vis[257] = true;
		vis[258] = true;
		vis[259] = true;
		vis[260] = true;
		vis[261] = true;
		vis[262] = true;
		vis[263] = true;
		vis[267] = true;
		vis[278] = true;
		vis[284] = true;
		vis[288] = true;
		vis[293] = true;
		vis[308] = true;
		vis[309] = true;
		vis[310] = true;
		vis[312] = true;
		vis[313] = true;
		vis[314] = true;
		vis[316] = true;
		vis[318] = true;
		vis[320] = true;
		vis[322] = true;
		vis[325] = true;
		vis[328] = true;
		vis[330] = true;
		vis[334] = true;
		vis[336] = true;
		vis[338] = true;
		vis[340] = true;
		vis[344] = true;
		vis[346] = true;
		vis[350] = true;
		vis[352] = true;
		vis[358] = true;
		vis[360] = true;
		vis[365] = true;
		vis[368] = true;
		vis[370] = true;
		vis[384] = true;
		vis[386] = true;
		vis[392] = true;
		vis[394] = true;
		vis[395] = true;
		vis[396] = true;
		vis[397] = true;
		vis[398] = true;
		vis[399] = true;
		vis[400] = true;
		vis[401] = true;
		vis[403] = true;
		vis[404] = true;
		vis[405] = true;
		vis[407] = true;
		vis[408] = true;
		vis[409] = true;
		vis[410] = true;
		vis[416] = true;
		vis[418] = true;

	}

}
