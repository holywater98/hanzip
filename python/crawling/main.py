from selenium import webdriver
from time import sleep
from openpyxl import Workbook

def crawling():
    # 크롬드라이버 주소.
    driver = webdriver.Chrome('/Users/sungsoopark/Desktop/chromedriver/chromedriver')
    driver.implicitly_wait(3)
    f = open("apart.txt",'w')

    for i in range(1,20001):
        url = 'https://new.land.naver.com/complexes/'+str(i)+'?&a=APT:JGC:ABYG&b=A1&e=RETAIL'
        driver.get(url)
        try:
            build_type = driver.find_element_by_xpath('//*[@id="summaryInfo"]/div[1]/span').text
        except:
            continue
        build_name = driver.find_element_by_xpath('//*[@id="complexTitle"]').text
        type1 = driver.find_element_by_xpath('//*[@id="summaryInfo"]/div[2]/div[1]/div/dl[1]/dt').text
        data1 = driver.find_element_by_xpath('//*[@id="summaryInfo"]/div[2]/div[1]/div/dl[1]/dd').text
        type2 = driver.find_element_by_xpath('//*[@id="summaryInfo"]/div[2]/div[1]/div/dl[2]/dt').text
        data2 = driver.find_element_by_xpath('//*[@id="summaryInfo"]/div[2]/div[1]/div/dl[2]/dd').text
        driver.find_element_by_xpath('//*[@id="summaryInfo"]/div[2]/div[2]/button[1]').click()
        sleep(0.5)
        try:
            address1 = driver.find_element_by_xpath('/html/body/div[2]/div/section/div[2]/div[2]/div/div[2]/div[3]/div[1]/table/tbody/tr[7]/td/p[1]').text
        except :
            try:
                address1 = driver.find_element_by_xpath('//*[@id="detailContents1"]/div[2]/table/tbody/tr[7]/td/p[1]').text
            except:
                try:
                    address1 = driver.find_element_by_xpath('//*[@id="detailContents1"]/div[1]/table/tbody/tr[8]/td/p[1]').text
                except:
                    try:
                        address1 = driver.find_element_by_xpath('//*[@id="detailContents1"]/div[2]/table/tbody/tr[8]/td/p[1]').text
                    except:
                        continue
        address_list=address1.split()
        if address_list[0] == '서울시' or address_list[0] == '경기도' or address_list[0] == '인천시' :
            datas = str(i)+'|'+build_type + '|' +build_name + '|'+address1+'|'+ type1+ '|'+data1+'|'+type2+'|'+data2+'\n'
            f.write(datas)
        # driver.close()
        if i%100 == 0 :
            print(i)
    f.close()
# 크롤링 오류로 여러 파일에 크롤링했을때 머지.
def txtmerge():
    filenames = ['apart1.txt', 'apart1401.txt', 'apart6601.txt']

    with open('apart.txt', 'w') as outfile:
        for filename in filenames:
            with open(filename) as file:
                for line in file:
                    outfile.write(line)


def aparttxt():
    f = open('apart.txt',"r")
    ff= open('apartt.txt','w')
    while True:
        line=f.readline()
        if not line: break
        list = line.split('|')
        print(line)
        if list[1]=='아파트':
            ff.write(line)
    f.close()
    ff.close()
# txtmerge()
aparttxt()

